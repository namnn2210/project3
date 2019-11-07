$(document).ready(function () {
    $('.btn-confirm').click(function () {
        swal({
            title: 'Are you sure ?',
            text: "Your order will be confirmed!",
            type: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes'
        }).then(function () {
            var orderId = $('.order').attr('id');
            var new_text = "";
            $.ajax({
                method: "post",
                url: "/confirmOrder",
                contentType: "application/json; charset=utf-8",
                dataType: 'json',
                data:orderId,
                success:function (resp) {
                    new_text = '<span class="badge badge-success py-1 px-2">';
                    new_text += 'Done';
                    new_text += '</span>';
                    $('.status'+orderId).html("");
                    $('.status'+orderId).append(new_text);
                    $('.btn-confirm').remove();
                    $('.btn-edit').remove();
                },
                error:function () {
                    swal("error");
                }
            });
        });
    });
});