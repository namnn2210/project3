$(".selection-1").select2({
    minimumResultsForSearch: 20,
    dropdownParent: $('#dropDownSelect1')
});

$(".selection-2").select2({
    minimumResultsForSearch: 20,
    dropdownParent: $('#dropDownSelect2')
});

$(document).ready(function () {
    $('.btn-add-to-cart').click(function (event) {
        var choose_size = $('.choose-size');
        var cart_quantity = $('.header-icons-noti');
        var item_quantity = $('.num-product').val();
        var cart_div = $('.header-cart');
        if (choose_size.val() !== 'S' && choose_size.val() !== 'M' && choose_size.val() !== 'L' && choose_size.val() !== 'XL') {
            swal("Please choose your size");
        } else {
            var product_id = $('#product-id').val();
            var product_data = {
                id: product_id,
                size: $('.choose-size').val(),
                quantity: item_quantity
            };
            event.preventDefault();
            $.ajax({
                type: "post",
                url: "/products/addToCart",
                contentType: 'application/json; charset=UTF-8',
                dataType: 'json',
                data: JSON.stringify(product_data),
                success: function (resp) {
                    if (resp.length === 0) {
                        swal("Null");
                    } else {
                        swal({
                            title: "Thanks!",
                            text: "Product is added to cart",
                            icon: "success"
                        });
                        console.log(resp.cartItem);
                        $('.header-cart-item').remove();
                        //Get total price
                        var totalPrice = 0;
                        for (var i in resp.cartItem) {
                            //Add cart quantity to 1
                            cart_quantity.text(resp.cartItem.length);
                            //Add item to cart
                            var listCartItem = "";
                            listCartItem += '<li class="header-cart-item">';
                            listCartItem += '<div class="header-cart-item-img">';
                            listCartItem += '<img src="' + resp.cartItem[i].product.url + '"' + 'alt="IMG">';
                            listCartItem += '</div>';
                            listCartItem += '<div class="header-cart-item-txt">';
                            listCartItem += '<span class="header-cart-item-name">';
                            listCartItem += resp.cartItem[i].product.name;
                            listCartItem += '</span>';
                            listCartItem += '<span class="header-cart-item-info">';
                            listCartItem += '<p>' + resp.cartItem[i].quantity + 'x' + resp.cartItem[i].product.price + '</p>';
                            listCartItem += '<p>' + "Size: " + resp.cartItem[i].size + '</p>';
                            listCartItem += '</span>';
                            listCartItem += '</div>';
                            listCartItem += '</li>';
                            totalPrice += resp.cartItem[i].quantity * resp.cartItem[i].product.price;
                            $('.header-cart-wrapitem').append(listCartItem);
                            //Add total price
                            var cartTotal = "";
                            cartTotal += '<div class="header-cart-total">';
                            cartTotal += 'Total: $' + totalPrice;
                            cartTotal += '</div>';
                            //Add 2 buttons
                            var cartButton = "";
                            cartButton += '<div class="header-cart-buttons">';
                            cartButton += '<div class="header-cart-wrapbtn">';
                            cartButton += '<a href="/cart/detail" class="flex-c-m size1 bg1 bo-rad-20 hov1 s-text1 trans-0-4">';
                            cartButton += 'View Cart';
                            cartButton += '</a>';
                            cartButton += '</div>';
                            cartButton += '<div class="header-cart-wrapbtn">';
                            cartButton += '<a href="#" class="flex-c-m size1 bg1 bo-rad-20 hov1 s-text1 trans-0-4">';
                            cartButton += 'Check Out';
                            cartButton += '</a>';
                            cartButton += '</div>';
                            cartButton += '</div>';
                            $('.header-cart-total').remove();
                            $('.header-cart-buttons').remove();
                            cart_div.append(cartTotal);
                            cart_div.append(cartButton);
                        }
                    }
                },
                error: function () {
                    swal("Error");
                }
            });
        }
    });
});