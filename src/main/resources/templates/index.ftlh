<html>
<head>
    <title></title>
</head>
<body>
<h2>Profile</h2>
<table>
    <tr>
        <th>Subject</th>
        <td>${token.getSubject()}</td>
    </tr>
    <tr>
        <th>Name</th>
        <td>${token.name}</td>
    </tr>
    <tr>
        <th>e-mail</th>
        <td>${token.email}</td>
    </tr>
    <tr>
        <th>Preferred username</th>
        <td>${token.preferredUsername}</td>
    </tr>
</table>
<h2>Scope</h2>
${token.scope}
<h2>Granted Authorities (spring-security)</h2>
<ul>
    <#list authorities as authority>
        <li>${authority.authority}</li>
    </#list>
</ul>
<h2>Roles</h2>
<h3>Realm Roles</h3>
<ul>
    <#list realmRoles as role>
        <li>${role}</li>
    </#list>
</ul>
<h3>Client Roles</h3>
<ul>
    <#list clientRoles as role>
        <li>${role}</li>
    </#list>
</ul>
<h2>Groups</h2>
<#if (token.otherClaims.groups)??>
    <ul>
        <#list token.otherClaims.groups as group>
            <li>${group}</li>
        </#list>
    </ul>
<#else>
    No "groups" claim present
</#if>
<h2>Token</h2>
<pre>${tokenJson}</pre>
</body>
</html>