<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'local.label', default: 'Local')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
        <asset:stylesheet href="gps.css"/>
    </head>
    <body>
        <a href="#show-local" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="show-local" class="content scaffold-show" role="main">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:display bean="local" />
            <g:form resource="${this.local}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.local}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
        </div>
        <div id="map"></div>
        <asset:javascript src="localizacion.js"/>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDVWhOl_toN0XyeiTsicovxfn7pm6HZyEU&callback=iniciarMapa"></script>
    </body>
</html>
<!--El div de la linea 31, el asset y el javascript son los dan la posicion del google maps,
si quieren que aparezca mas arriba muvan esos 3 tags. Los archivos son gps.css y localizain.js
vean el js porque la localizacion le puse la latitud y longitud directa en el codigo, así que 
deben hacer que la latitud y longitud sean dianmicas dependiendo de lo ingresado-->