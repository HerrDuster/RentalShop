<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@attribute name="category" required="true" type="java.util.Collection" %>
<%@attribute name="searchForm" required="true" type="com.systemnet.shop.form.SearchForm" %>

<div class="panel-heading">Category filter</div>
<div class="panel-body category">
    <label><input type="checkbox" id="allProducer">All</label>
    <c:forEach var="category" items="${category}">
        <div class="form-group">
            <div class="checkbox">
                <label><input type="checkbox" name="category" value="${category.id}" class="search-option">
                        ${category.name}(${category.producerCount})
                </label>
            </div>
        </div>
    </c:forEach>
</div>