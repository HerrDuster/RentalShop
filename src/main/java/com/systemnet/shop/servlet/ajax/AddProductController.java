package com.systemnet.shop.servlet.ajax;

import com.systemnet.shop.form.ProductForm;
import com.systemnet.shop.model.ShoppingCart;
import com.systemnet.shop.servlet.AbstractController;
import com.systemnet.shop.util.RoutingUtils;
import com.systemnet.shop.util.SessionUtils;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ajax/json/products/add")
public class AddProductController extends AbstractController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductForm productForm = createProductForm(req);
        ShoppingCart shoppingCart = SessionUtils.getCurrentShoppingCart(req);
        getOrderService().addProductToShoppingCart(productForm, shoppingCart);

        JSONObject r = new JSONObject();
        r.put("totalCount", shoppingCart.getTotalCount());
        r.put("totalCoast", shoppingCart.getTotalCoast());

        RoutingUtils.sendJson(r,req, resp);
    }
}
