<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@attribute name="producer" required="true" type="java.util.Collection" %>

<div class="panel-heading">Producer filter</div>
<div class="panel-body producer">
    <label><input type="checkbox" id="allProducer">All</label>
    <c:forEach var="producer" items="${producer}">
        <div class="form-group">
            <div class="checkbox">
                <label><input type="checkbox" name="producer" value="${producer.id}" class="search-option">
                ${producer.name}(${producer.producerCount})
                </label>
            </div>
        </div>
    </c:forEach>
</div>