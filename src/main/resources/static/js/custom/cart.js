$(document).ready(function () {
   $('.btn-num-product-down').click(function (event) {
       event.preventDefault();
       updateCart();
   });

    $('.btn-num-product-up').click(function (event) {
        event.preventDefault();
        updateCart();
    });
});

$('.btn-update-cart').click(function () {
    window.location.reload();
});

$('.cart-img-product').click(function (event) {
    event.preventDefault();
    var deleteId = $('.table-row').attr("id").replace('item-','');
    var size = $('.table-row').attr("name");
    var delete_product = {
        id:deleteId,
        size:size
    };
    if(confirm("Are you sure")) {
        $.ajax({
            method:"post",
            url:"/cart/removeCartProduct",
            contentType: 'application/json; charset=UTF-8',
            dataType: 'json',
            data: JSON.stringify(delete_product),
            success:function (resp) {
                console.log(resp);
                swal("Product is deleted");
                $("#item-" + deleteId).remove();
                $('.header-icons-noti').text(resp.cartItem.length);
                $('.total-price').text('$' + resp.totalPrice);
            },
            error:function () {
                swal("Error");
            }
        })
    }
});

function updateCart() {
    var product_id = $('#product-id').val();
    var current_quantity = parseInt($('.num-product').val());
    var update_products = [];
    $('.num-product').each(function () {
        update_products.push({id:$(this).attr("name"),size:$(this).attr("id"), quantity:$(this).val()});
    });
    $.ajax({
        type:"post",
        url: "/cart/updateCart",
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        data: JSON.stringify(update_products),
        success:function (resp) {
            console.log(resp);
            for(var i in resp.cartItem) {
                var item_class = 'item-' + resp.cartItem[i].size;
                $('.num-product' + item_class).val(resp.cartItem[i].quantity);
                $('.'+item_class).text('$' +resp.cartItem[i].quantity * resp.cartItem[i].product.price);
            }
            $('.sub-total').text('$' +resp.totalPrice);
            $('.total-price').text('$' + resp.totalPrice);
        },
        error:function () {
            swal("Error");
        }
    });
}