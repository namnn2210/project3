$(document).ready(function () {
    $('.glyphicon-trash').click(function (event) {
        var prodId = $(this).parent().parent().parent().parent().parent().attr('id').replace('item-','');
        swal({
            title: 'Are you sure ?',
            text: "Your product will be inactive!",
            type: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it!'
        }).then(function () {
            alert(prodId);
            var new_text = "";
            console.log(prodId);
            $.ajax({
                method: "post",
                url: "/products/deleteProduct",
                contentType: "application/json; charset=utf-8",
                dataType: 'json',
                data: prodId,
                success: function (resp) {
                    new_text = '<span class="badge badge-danger py-1 px-2">';
                    new_text += 'Inactive';
                    new_text += '</span>';
                    $('.status' + prodId).html("");
                    $('.status' + prodId).append(new_text);
                },
                error: function () {
                    swal("error");
                }
            });
        });
    });
});
