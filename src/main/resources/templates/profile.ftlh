<!doctype html>
<html lang="en">
<head>
    <#include "/partials/head.ftlh">
    <title>${title}</title>
</head>
<body>
<#include "/partials/header.ftlh">
<section class="section">
    <div class="container">
        <h2 class="section__title">Профиль</h2>
        <div class="profile-page">
            <div class="row">
                <div class="col-12 col-md-6 col-lg-4 mb-4 mb-md-0">
                    <div class="profile-page__section profile-page__profile profile">
                        <form action="/profile" method="post" id="updateProfileForm">
                            <div class="profile__row">
                                <label for="firstNameInput">Имя:</label>
                                <input name="firstName" type="text" id="firstNameInput" value="${user.firstName}"
                                       readonly>
                            </div>
                            <div class="profile__row">
                                <label for="lastNameInput">Фамилия:</label>
                                <input name="lastName" type="text" id="lastNameInput" value="${user.lastName}" readonly>
                            </div>
                            <div class="profile__row profile__row_mb_l">
                                <label for="telegramChatIdInput">Telegram Chat Id:</label>
                                <input name="telegramChatId" type="text" id="telegramChatIdInput" value="${user.telegramChatId}" readonly>
                            </div>
                            <div class="profile__row">
                                <div class="row">
                                    <div class="col-12 col-sm-6 mb-3 mb-sm-0">
                                        <button type="submit" id="changeButton" class="button button_outline">Изменить
                                        </button>
                                    </div>
                                    <div class="col-12 col-sm-6">
                                        <a href="/auth/logout" id="logoutButton" class="button button_red">Выйти</a>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-12 col-md-6 col-lg-8">
                    <div class="profile-page__section profile-page__group group">
                        <#if user.group??>
                            <h3 class="profile-page__title mb-3">Вы состоите в группе: <span>${user.group.title}</span>
                            </h3>
                            <h3 class="profile-page__title">Код группы: <span>${user.group.code}</span></h3>
                        <#else>
                            <form action="/group/join" method="post">
                                <div class="row mb-4">
                                    <div class="col-12 col-lg-8 mb-2 mb-lg-0">
                                        <input class="w-100 h-100 p-2 rounded-0 border border-secondary text-center"
                                               type="text" placeholder="Введите код группы" name="code">
                                    </div>
                                    <div class="col-12 col-lg-4">
                                        <button type="submit" class="button button_outline">Присоединиться</button>
                                    </div>
                                </div>
                            </form>
                            <form action="/group/create" method="post">
                                <div class="row">
                                    <div class="col-12 col-lg-8 mb-2 mb-lg-0">
                                        <input class="w-100 h-100 p-2 rounded-0 border border-secondary text-center"
                                               type="text" placeholder="Введите название группы" name="title">
                                    </div>
                                    <div class="col-12 col-lg-4">
                                        <button type="submit" class="button button_outline">Создать</button>
                                    </div>
                                </div>
                            </form>
                        </#if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>