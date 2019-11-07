$(document).ready(function () {
    $('.btn-delete-cat').click(function () {
        swal({
            title: 'Are you sure ?',
            text: "Your category will be inactive and all your products in this category will also be inactive!",
            type: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it!'
        }).then(function () {
            var catId = $('.category').attr('id');
            console.log(catId);
            var new_text = "";
            $.ajax({
                method: "post",
                url: "/deleteCategory",
                contentType: "application/json; charset=utf-8",
                dataType: 'json',
                data:catId,
                success:function (resp) {
                    new_text = '<span class="badge badge-danger py-1 px-2">';
                    new_text += 'Inactive';
                    new_text += '</span>';
                    $('.status'+catId).html("");
                    $('.status'+catId).append(new_text);
                },
                error:function () {
                    swal("error");
                }
            });
        });
    });
});