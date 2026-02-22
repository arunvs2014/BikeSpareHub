package com.bikesparehub.bikesparehub.controller;

import com.bikesparehub.bikesparehub.model.BikePart;
import com.bikesparehub.bikesparehub.model.CartItem;
import com.bikesparehub.bikesparehub.repository.BikePartRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import java.util.*;

@Controller
public class CartController {

    private final BikePartRepository repository;

    public CartController(BikePartRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/cart/add/{id}")
    public String addToCart(@PathVariable Long id, HttpSession session) {

        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }

        Optional<BikePart> part = repository.findById(id);
        if (part.isPresent()) {
            boolean found = false;

            for (CartItem item : cart) {
                if (item.getId().equals(id)) {
                    item.setQuantity(item.getQuantity() + 1);
                    found = true;
                    break;
                }
            }

            if (!found) {
                cart.add(new CartItem(
                        part.get().getId(),
                        part.get().getPartName(),
                        part.get().getPrice(),
                        1
                ));
            }
        }

        session.setAttribute("cart", cart);
        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String viewCart(HttpSession session, Model model) {

        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) cart = new ArrayList<>();

        model.addAttribute("cartItems", cart);

        double total = cart.stream()
                .mapToDouble(CartItem::getTotalPrice)
                .sum();

        model.addAttribute("total", total);

        return "cart";
    }
}