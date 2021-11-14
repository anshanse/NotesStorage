<#import "parts/common.ftlh" as p>
<@p.page>
List of Users
<table>
    <thead>
    <th>Name</th>
    <th>Role</th>
    <th></th>
    </thead>
    <tbody>
    <#list users as user>
    <tr>
        <td>${user.username}</td>
        <td><#list user.roles as role>${role}<#sep>, </#list></td>
        <td><a href="/users/${user.id}">Edit</a></td>
    </tr>
    </#list>
    </tbody>
</table>
</@p.page>