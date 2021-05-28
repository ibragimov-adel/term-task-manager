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
        <div class="section__header">
            <h2 class="section__title">Задачи</h2>
            <button
                    class="button button_outline section__header-button"
                    data-bs-toggle="modal"
                    data-bs-target="#createTaskModal"
            >Создать
            </button>
        </div>
        <div class="tasks-page">
            <div class="row">
                <#list tasks as task>
                    <div class="col-12 col-sm-6 col-lg-4">
                        <a href="/tasks/${task.id}">
                            <div
                                    <#if task.finished>
                                        class="tasks-page__task tasks-page__task_finished"
                                    <#else>
                                        class="tasks-page__task"
                                    </#if>
                            >
                                <div class="tasks-page__task-title">${task.title}</div>
                                <div class="tasks-page__task-creator">
                                    Постановщик: ${task.creator.firstName} ${task.creator.lastName}</div>
                            </div>
                        </a>
                    </div>
                </#list>
            </div>
        </div>
    </div>
</section>
<div id="createTaskModal" class="modal fade">
    <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
        <div class="modal-content">
            <form action="/tasks" method="post">
                <div class="modal-header">
                    <h5 class="modal-title">Создание задачи</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="mb-3">
                        <label class="form-label" for="titleInput">Название</label>
                        <input class="form-control" type="text" id="titleInput" name="title">
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="descriptionInput">Описание</label>
                        <textarea class="form-control" type="text" id="descriptionInput" name="description"></textarea>
                    </div>
                    <div class="mb-3">
                        <select name="doers" multiple id="" class="form-select">
                            <#list users as user>
                                <option value="${user.id}">${user.firstName} ${user.lastName}</option>
                            </#list>
                        </select>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="button button_outline w-auto">Создать</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>