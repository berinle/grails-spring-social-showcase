<html>
<head>
    <title>Twitter Profile</title>
    <meta name='layout' content='springSocialMain'/>
</head>

<body>

<g:set var="connectionFactories" value="${springsocial.registeredProviderIds()}"/>

<ul>
  <sec:ifLoggedIn>
    You are logged as <b> <sec:loggedInUserInfo field="username"/> </b>
  </sec:ifLoggedIn>
  <sec:ifNotLoggedIn>
    You aren't logged yet...
  </sec:ifNotLoggedIn>
  <g:each in="${connectionFactories}" var="providerId">
    <g:set var="connected" value="${springsocial.isCurrentUserConnectedTo(providerId: providerId)}"/>
    <li>
      <g:if test="${Boolean.valueOf(connected)}">
        <g:set var="profiles" value="${springsocial.currentUserProfilesToService(providerId:providerId)}"/>
        <g:each in="${profiles}" var="profile">
          You're connected to <b>${providerId.capitalize()}</b> as
          <g:link controller="springSocial${providerId.capitalize()}">
            <b>${profile.name}</b>
          </g:link>
        </g:each>
      </g:if>
      <g:else>
        You aren't connected to <b>${providerId.capitalize()}</b>
        <g:link controller="springSocial${providerId.capitalize()}">
          Connect
        </g:link>
      </g:else>
    </li>
  </g:each>
</ul>

</body>
</html>
