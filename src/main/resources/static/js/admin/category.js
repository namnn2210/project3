$(document).ready(function () {
    $('.glyphicon-trash').click(function (event) {
        event.preventDefault();
        var catId = $(this).parent().parent().parent().parent().parent().attr('id');
        swal({
            title: 'Are you sure ?',
            text: "Your category will be inactive and all your products in this category will also be inactive!",
            type: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it!'
        }).then(function () {
            var new_text = "";
            $.ajax({
                method: "post",
                url: "/deleteCategory",
                contentType: "application/json; charset=utf-8",
                dataType: 'json',
                data: catId,
                success: function (resp) {
                    new_text = '<span class="badge badge-danger py-1 px-2">';
                    new_text += 'Inactive';
                    new_text += '</span>';
                    $('.status' + catId).html("");
                    $('.status' + catId).append(new_text);
                },
                error: function () {
                    swal("error");
                }
            });
        });
    });
});