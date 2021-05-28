<!doctype html>
<html lang="en">
<head>
    <#include "/partials/head.ftlh">
    <title>${title}</title>
</head>
<body>
<section class="auth-page">
    <div id="loginForm" class="auth-form">
        <form action="/auth/login" method="post">
            <h2 class="auth-form__title">Вход</h2>
            <div class="auth-form__row">
                <label for="usernameInput">Имя пользователя</label>
                <input name="username" id="usernameInput" type="text">
            </div>
            <div class="auth-form__row mb-5">
                <label for="passwordInput">Пароль</label>
                <input name="password" id="passwordInput" type="password">
            </div>
            <button type="submit" class="button button_outline mb-3">Войти</button>
            <div id="authErrorBox" class="auth-form__error auth-form__error_hidden"></div>
            <span class="auth-form__toggle">Нет аккаунта?</span>
        </form>
    </div>
    <div id="regForm" class="auth-form auth-form_hidden">
        <form action="/auth/register" method="post">
            <h2 class="auth-form__title">Регистрация</h2>
            <div class="auth-form__row">
                <label for="regFirstNameInput">Имя</label>
                <input name="firstName" id="regFirstNameInput" type="text">
            </div>
            <div class="auth-form__row">
                <label for="regLastNameInput">Фамилия</label>
                <input name="lastName" id="regLastNameInput" type="text">
            </div>
            <div class="auth-form__row">
                <label for="regUsernameInput">Имя пользователя</label>
                <input name="username" id="regUsernameInput" type="text">
            </div>
            <div class="auth-form__row mb-5">
                <label for="regPasswordInput">Пароль</label>
                <input name="password" id="regPasswordInput" type="password">
            </div>
            <button type="submit" class="button button_outline mb-3">Регистрация</button>
            <span class="auth-form__toggle">У меня есть аккаунт</span>
        </form>
    </div>
</section>
</body>
</html>