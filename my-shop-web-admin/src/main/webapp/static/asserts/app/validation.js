var Validation = function () {
    var handlerInitValidation = function () {
        $.validator.addMethod('mobile', function (value, element) {
            var length = value.length;
            var mobile = /^1(3|4|5|7|8)\d{9}$/;
            return this.optional(element) || (length === 11 && mobile.test(value));
        }, '手机号码格式错误');
        var valid = $('#userForm').validate({
            errorElement: 'span',
            errorClass: 'help-block',
            errorPlacement: function (error, element) {
                element.parent().parent().addClass('has-error');
                error.insertAfter(element);
            },
            unhighlight: function (element, errorClass, validClass) {
                $(element).parent().parent().removeClass('has-error');
                if (element.type === "radio") {
                    this.findByName(element.name).removeClass(errorClass).addClass(validClass);
                } else {
                    $(element).removeClass(errorClass).addClass(validClass);
                }
            }
        });
    };
    return {
        init: function () {
            handlerInitValidation();
        }
    }
}();
$(document).ready(function () {
    Validation.init();
});