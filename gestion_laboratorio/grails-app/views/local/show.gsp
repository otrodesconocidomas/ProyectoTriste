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
            <div id="map"></div>
            <script>                
            function iniciarMapa(){
                <% 
                    def latitudJS="${this.local.latitud}"
                    def longitudJS="${this.local.longitud}"
                %>
                var coord = {lat: <%=latitudJS%>, lng: <%=longitudJS%>};
                var map = new google.maps.Map(document.getElementById('map'),{
                zoom: 18,
                center: coord
                });
                var marker = new google.maps.Marker({
                position: coord,
                map: map
                });
            }
            </script>
            <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDVWhOl_toN0XyeiTsicovxfn7pm6HZyEU&callback=iniciarMapa"></script>
            <g:form resource="${this.local}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.local}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
