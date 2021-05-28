<!doctype html>
<html lang="en">
<head>
    <#include "/partials/head.ftlh">
    <title>${title}</title>
</head>
<body>
<#include "/partials/header.ftlh">
<section class="section task-page">
    <div class="container">
        <div class="task-details">
            <div class="mb-5">
                <div class="mb-4">
                    <h5>Создатель: ${task.creator.firstName} ${task.creator.lastName}</h5>
                </div>
                <div class="mb-3">
                    <h3>Название</h3>
                    <p>${task.title}</p>
                </div>
                <div class="mb-3">
                    <h3>Описание</h3>
                    <p>${task.description}</p>
                </div>
                <form action="/tasks/${task.id}" method="post">
                    <input type="hidden" name="finished" value="${formValue?c}">
                    <button type="submit" class="button button_outline w-auto ms-auto">
                        <#if task.finished>
                            Отметить как незавершенное
                        <#else>
                            Завершить
                        </#if>
                    </button>
                </form>
            </div>
            <div class="comments mb-5" id="commentsContainer">
                <#list task.comments as comment>
                    <div class="comment mb-4 border-start border-dark ps-2">
                        <div class="d-flex justify-content-between align-items-center">
                            <h6>${comment.creator.firstName} ${comment.creator.lastName}</h6>
                            <#if comment.creator.id = user.id>
                                <span data-target="deleteComment" data-comment="${comment.id}">X</span>
                            </#if>
                        </div>
                        <p>${comment.message}</p>
                    </div>
                </#list>
            </div>
            <div class="mb-3">
                <label for="commentTextarea" class="form-label">Комментарий</label>
                <textarea id="commentTextarea" cols="30" rows="10" class="form-control"></textarea>
            </div>
            <div>
                <input id="taskIdInput" type="hidden" value="${task.id}">
                <button id="sendCommentButton" class="button button_outline w-auto">Отправить комментарий</button>
            </div>
        </div>
    </div>
</section>
</body>
</html>