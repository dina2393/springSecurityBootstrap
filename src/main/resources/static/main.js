$('document').ready(function() {
    $('.table .eBtn').on('click',function(event){
        // event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function(user,status){
            $('.editForm #idEdit').val(user.id);
            $('.editForm #nameEdit').val(user.userName);
            $('.editForm #lastNameEdit').val(user.lastName);
            $('.editForm #ageEdit').val(user.age);
            $('.editForm #emailEdit').val(user.email);
            $('.editForm #passwordEdit').val(user.password);

        });

        $('.editForm #editModal').modal();

    });
});
