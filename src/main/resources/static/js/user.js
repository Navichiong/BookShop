$(function () {
    $('#username').blur(validUsername);
    $('#password').blur(validPassword);
    $('#email').blur(validEmail);
    $('#phone').blur(validPhone);
    $('#check_password').blur(checkSamePwd);
    $('#showRegModal').click(function () {
        reset_form('#register form');
    })
});

// 重置表单
function reset_form(ele) {
    $(ele)[0].reset();
    //清空表单样式
    // $(ele).find("*").removeClass("has-error has-success");
    $(ele).find(".alert-danger").text("");
    $(ele).find(".alert-success").text("");
}

// 检测用户是否可用,可用则提交
function checkUser(obj) {

    $.get({
        url: contextPath + '/user/checkUsername',
        data: {'username': $(obj).val()},
        success: function (data) {
            $('#usernameMsg').css('display', 'block');
            if (data.code === 100) {
                $('#usernameTip').html(data.message).addClass('alert-success').removeClass('alert-danger');
                $('#submitBtn').attr('status', true);

                var datas = $('#registerForm').serialize();
                $.post({
                    url: contextPath + '/user/register',
                    data: datas,
                    success: function (data) {
                        if (data.code === 100) {
                            alert('注册成功，请登录！');
                            $('#register').modal('hide');
                        } else if (data.code === 200) {
                            if (data.data.username) {
                                $('#usernameTip').html("用户名长度只能3~16").addClass('alert-danger').removeClass('alert-success');
                            }
                            if (data.data.password) {
                                $('#passwdMsg label').html("密码不合法，需要6~18位数字和字母的组合").addClass('alert-danger').removeClass('alert-success');
                            }
                            if (data.data.email) {
                                $('#emailMsg label').html("邮箱不合法").addClass('alert-danger').removeClass('alert-success');
                            }
                            if (data.data.phone) {
                                $('#phoneMsg label').html('手机号可用').addClass('alert-success').removeClass('alert-danger');
                            }
                        }
                    }
                })
            } else if (data.code === 200) {
                $('#usernameTip').html(data.message).addClass('alert-danger').removeClass('alert-success');
            }
        }
    })
}

// 校验用户名格式
function validUsername() {
    if (!valid('#username', /^[a-z0-9_-]{3,16}$/)) {
        $('#usernameTip').html("用户名长度只能3~16").addClass('alert-danger').removeClass('alert-success');
        return false;
    }
    return true;
}

// 检查两次密码输入是否一致
function checkSamePwd() {
    var check_pwd = $('#check_password').val();
    var pwd = $('#password').val();
    if (pwd != check_pwd) {
        $('#checkPasswdMsg label').html("两次密码输入不一致").addClass('alert-danger').removeClass('alert-success');
        return false;
    }
    $('#checkPasswdMsg label').html('两次密码一致').addClass('alert-success').removeClass('alert-danger');
    return true;
}

// 校验密码格式
function validPassword() {
    if (!valid('#password', /^[a-z0-9_-]{3,16}$|^[\u2E80-\u9FFF]{3,16}$/)) {
        $('#passwdMsg label').html("密码不合法，需要6~18位数字和字母的组合").addClass('alert-danger').removeClass('alert-success');
        return false;
    }
    $('#passwdMsg label').html('密码可用').addClass('alert-success').removeClass('alert-danger');
    return true;
}

// 校验邮箱格式
function validEmail() {
    if (!valid('#email', /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/)) {
        $('#emailMsg label').html("邮箱不合法").addClass('alert-danger').removeClass('alert-success');
        return false;
    }
    $('#emailMsg label').html('邮箱可用').addClass('alert-success').removeClass('alert-danger');
    return true;
}

// 校验手机号格式
function validPhone() {
    if (!valid('#phone', /^1([3456789])\d{9}$/)) {
        $('#phoneMsg label').html('非法手机号').addClass('alert-danger').removeClass('alert-success');
        return false;
    }
    $('#phoneMsg label').html('手机号可用').addClass('alert-success').removeClass('alert-danger');
    return true;
}

function register() {
    $('#submitBtn').attr("status", false);

    if (!validUsername() || !validPassword() || !validEmail() || !validPhone() || !checkSamePwd()) {
        return false;
    }

    console.log('校验正确');

    checkUser('#username');
}

function valid(ele_str, regxp) {
    var val = $(ele_str).val();
    return regxp.test(val);
}

// 登录
function login() {

    var loginData = $('#loginForm').serialize();
    $.post({
        url: contextPath + '/user/login',
        data: loginData,
        success: function (response) {
            if (response.code === 100) {
                alert('登录成功！');
                $('#loginModal').show('hide');
                window.location.href = contextPath + '/home/index'
            } else if (response.code === 200) {
                alert('用户名或密码错误！')
            }
        }
    })
}