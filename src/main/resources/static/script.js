$(function () {
    const changeButton = $('#changeButton');
    const inputs = [$('#firstNameInput'), $('#lastNameInput'), $('#telegramChatIdInput')];
    let isChange = false;

    changeButton.click(toggleChange);

    function toggleChange() {
        const text = isChange ? 'Изменить' : 'Сохранить';
        changeButton.text(text);

        isChange = !isChange;
        inputs.forEach(input => input.prop('readonly', !isChange));
    }

    const authFormToggleButton = $('.auth-form__toggle');
    const loginForm = $('#loginForm');
    const registrationForm = $('#regForm');

    authFormToggleButton.click(toggleForm);

    const updateProfileForm = $('#updateProfileForm');
    updateProfileForm.submit(function (e) {
        if (isChange) {
            e.preventDefault();
        }
    });

    function toggleForm() {
        loginForm.toggleClass('auth-form_hidden');
        registrationForm.toggleClass('auth-form_hidden');
    }

    const urlParams = new URLSearchParams(window.location.search);
    const isError = urlParams.has('error');
    if (isError) {
        const authErrorBox = $('#authErrorBox');
        authErrorBox.text('Некорректные данные для входа');
        authErrorBox.removeClass('auth-form__error_hidden')
    }

    const commentTextarea = $('#commentTextarea');
    const sendCommentButton = $('#sendCommentButton');
    const taskId = $('#taskIdInput').val();
    const commentsContainer = $('#commentsContainer');

    sendCommentButton.click(function () {
        const message = commentTextarea.val();
        commentTextarea.val("");

        $.ajax({
            type: 'POST',
            url: '/comments',
            data: JSON.stringify({message, task: taskId}),
            contentType: 'application/json; charset=utf-8',
            success: function (data) {
                commentsContainer.append(function() {
                    return $(generateComment(data.message, data.creator, data.id)).click(handleDelete);
                });
            },
            error: function () {
                alert('Ошибка при отправке комментария. Попробуйте позже.');
            }
        })
    });

    function handleDelete(e) {
        const commentToDelete = $(e.target).closest('.comment');
        const commentId = $(e.target).data('comment');

        $.ajax({
            type: 'DELETE',
            url: `/comments/${commentId}`,
            success: function () {
                commentToDelete.remove();
            },
            error: function () {
                alert('Ошибка при удалении комментария. Попробуйте позже.')
            }
        });
    }

    function generateComment(message, creator, id) {
        return `
            <div class="comment mb-4 border-start border-dark ps-2">
                <div class="d-flex justify-content-between align-items-center">
                    <h6>${creator}</h6>
                    <span data-target="deleteComment" data-comment="${id}">X</span>
                </div>
                <p>${message}</p>
            </div>
        `
    }

    $('[data-target="deleteComment"]').click(handleDelete);

});