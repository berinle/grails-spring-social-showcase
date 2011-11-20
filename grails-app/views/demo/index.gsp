<html>
<head>
    <title>Twitter Profile</title>
    <parameter name="leftMenu" value="/demo/menu"/>
    <meta name='layout' content='springSocialMain'/>
</head>

<body>

<g:set var="connectionFactories" value="${springsocial.registeredProviderIds()}"/>

<ul>
    <g:each in="${connectionFactories}" var="providerId">
        <g:set var="connected" value="${springsocial.isCurrentUserConnectedTo(providerId: providerId)}" />
        <li>CurrentUser is Connected to ${providerId}: ${connected}
            <g:if test="${Boolean.valueOf(connected)}">
                <ul>
                    <g:set var="profiles" value="${springsocial.currentUserProfilesToService(providerId:providerId)}"/>
                    <g:each in="${profiles}" var="profile">
                        <li>
                            ${providerId} profile: ${profile.name}
                        </li>
                    </g:each>
                </ul>
            </g:if>
        </li>
    </g:each>
</ul>

</body>
</html>
