<#import "parts/common.ftlh" as p>
<@p.page>
<div class="">
    <div class="row ">
        <p class="fs-3 ">My notes - ${noteCount} pcs.</p>
        <div>
        <button type="button" class="btn btn-primary mb-3 col-auto" onclick="location.href='/note/create'">Create note</button>
        </div>
    </div>

    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Message</th>
            <th scope="col">Access type</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <#list notes as note>
        <tbody>
        <tr>
            <td>${note.name}</td>
            <td>${note.message}</td>
            <td>@${note.accessType}</td>
            <td></td>
        </tr>
        <#else>
<!--        No message-->
        </#list>
        </tbody>
    </table>

</div>
</@p.page>