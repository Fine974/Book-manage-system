document.addEventListener('DOMContentLoaded', function () {
    // 从会话存储中获取用户信息
    var user = JSON.parse(sessionStorage.getItem('user'));

    // 如果用户信息存在且包含username属性
    if (user && user.username) {
        // 创建下拉菜单元素
        var dropdownItem = document.createElement('ul');
        dropdownItem.className = 'navbar-nav';

        // 创建下拉菜单的内容
        dropdownItem.innerHTML = `
              <li class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="color: white">
                欢迎，${user.username}!
              </li>
              <div class="dropdown-menu dropdown-menu-right">
                <a class="dropdown-item" href="/cart/${user.id}">购物车</a>
                <a class="dropdown-item" href="#">个人信息</a>
                <a class="dropdown-item" href="#">设置</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#" id="logoutBtn">注销</a>
              </div>
            `;

        // 将下拉菜单添加到导航栏
        document.getElementById('navbarColor01').appendChild(dropdownItem);

        // 隐藏登录和注册按钮
        document.getElementById('loginBtn').style.display = 'none';
        document.getElementById('registerBtn').style.display = 'none';

        // 添加注销按钮的点击事件
        document.getElementById('logoutBtn').addEventListener('click', function () {
            // 清除会话存储中的用户信息
            sessionStorage.removeItem('user');
            // 重新加载页面或进行其他操作，比如跳转到登录页面
            window.location.href = '/';
        });
        if (user.role === 1) {
            var adminLink = document.createElement('li');
            adminLink.className = 'nav-item';
            adminLink.innerHTML = '<a class="nav-link" href="#">后台管理</a>';
            document.getElementById('adminNavItem').appendChild(adminLink);
        }
    }
});