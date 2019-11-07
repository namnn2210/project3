$(document).ready(function () {
    $('.btn-delete-team').click(function () {
        var teamId = $(this).parent().parent().parent().parent().attr('id');
        swal({
            title: 'Are you sure ?',
            text: "Your team will be inactive and all your products in this team will also be inactive!",
            type: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it!'
        }).then(function () {
            var new_text = "";
            $.ajax({
                method: "post",
                url: "/deleteTeam",
                contentType: "application/json; charset=utf-8",
                dataType: 'json',
                data:teamId,
                success:function (resp) {
                    new_text = '<span class="badge badge-danger py-1 px-2">';
                    new_text += 'Inactive';
                    new_text += '</span>';
                    $('.status'+teamId).html("");
                    $('.status'+teamId).append(new_text);
                },
                error:function () {
                    swal("error");
                }
            });
        });
    });
});