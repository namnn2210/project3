$(document).ready(function () {
    $('.btn-confirm').click(function () {
        var orderId = $(this).parent().parent().parent().parent().attr('id');
        swal({
            title: 'Are you sure ?',
            text: "Your order will be confirmed!",
            type: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes'
        }).then(function () {
            var new_text = "";
            $.ajax({
                method: "post",
                url: "/confirmOrder",
                contentType: "application/json; charset=utf-8",
                dataType: 'json',
                data: orderId,
                success: function (resp) {
                    new_text = '<span class="badge badge-success py-1 px-2">';
                    new_text += 'Done';
                    new_text += '</span>';
                    $('.status' + orderId).html("");
                    $('.status' + orderId).append(new_text);
                    $('.confirm-item-' + orderId).remove();
                    $('.edit-item-' + orderId).remove();
                },
                error: function () {
                    swal("error");
                }
            });
        });
    });
    var count = 1;
    $('.btn-add-product').click(function () {
        var new_content = '';
        var content = $('.order-detail-'+count).html();
        var next_count = count+1;
        new_content += '<tr class="order-detail-' + next_count + '"' + '>';
        new_content += content;
        new_content += '</tr>';
        $('.order-detail-'+count).after(new_content);
        count++;
    });
});