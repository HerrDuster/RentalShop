package com.systemnet.shop.servlet.ajax;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.systemnet.shop.Constants;
import com.systemnet.shop.entity.Product;
import com.systemnet.shop.form.SearchForm;
import com.systemnet.shop.servlet.AbstractController;
import com.systemnet.shop.util.RoutingUtils;


@WebServlet("/ajax/html/more/search")
public class SearchResultsMoreController extends AbstractController {
	private static final long serialVersionUID = -2651974520717714088L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SearchForm searchForm = createSearchForm(req);
		List<Product> products = getProductService().listProductsBySearchForm(searchForm, getPage(req), Constants.MAX_PRODUCTS_PER_HTML_PAGE);
		RoutingUtils.forwardToFragment("product-list.jsp", req, resp);
	}
}
