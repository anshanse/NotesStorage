<#import "parts/common.ftlh" as p>
<@p.page>
<div class="">
    <div class="row ">
        <p class="fs-3 ">My notes - ${noteCount} pcs.</p>
        <div>
        <button type="button" class="btn btn-primary mb-3 col-auto" onclick="location.href='/note/create'">Create note</button>
        </div>
    </div>

    <table class="table table-striped table-hover table-hover-cursor" style="table-layout: fixed">
        <thead>
        <tr>
            <th class="col-2" scope="col">Name</th>
            <th class="col-5" scope="col">Message</th>
            <th class="col-1" scope="col">Access type</th>
            <th class="col-1" scope="col"></th>
        </tr>
        </thead>
        <#list notes as note>
        <tbody>
        <tr class="">
            <td class="text-truncate">${note.name}</td>
            <td class="text-truncate">${note.message}</td>
            <td class="ml-10">${note.accessType}</td>
            <td></td>
        </tr>
        <#else>
<!--        No message-->
        </#list>
        </tbody>
    </table>

</div>
</@p.page>