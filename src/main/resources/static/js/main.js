$(document).ready(function() {
    console.log('Document is ready.');

    // 使用 Ajax 请求检查用户是否已登录
    $.ajax({
        url: "/users/check-login",
        method: "GET",
        dataType: "json",
        success: function(response) {
            console.log('Ajax request success:', response);

            var loginButtonsContainer = $("#loginButtonsContainer");
            if (response.loggedIn) {
                // 用户已登录，显示用户名和注销按钮
                console.log('User is logged in. Username:', response.username);
                loginButtonsContainer.html(
                    '<span>' + response.username + '</span>' +
                    '<a class="btn btn-primary" href="/logout" role="button">注销</a>'
                );
            } else {
                // 用户未登录，显示登录和注册按钮
                console.log('User is not logged in.');
                loginButtonsContainer.html(
                    '<a class="btn btn-primary" href="/loginPage" role="button">登录</a>' +
                    '<a class="btn btn-primary" href="/registerPage" role="button">注册</a>'
                );
            }
        },
        error: function(error) {
            console.error("Ajax request failed: ", error);
        }
    });
});
