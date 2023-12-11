function fetchData(type) {
    // Update active class for tabs
    if (event) {
        // Update active class for tabs
        document.querySelectorAll('.nav-item .nav-link').forEach(tab => {
            tab.classList.remove('active');
        });
        event.currentTarget.classList.add('active');
    }

    fetch(`http://localhost:8080/${type}`)
        .then(response => response.json())
        .then(data => {
            if (type === 'productsAll') {
                updateProductTable(data); // Update the table with product data
            } else if (type === 'usersAll') {
                updateUserTable(data)
            }
            else if (type === 'ordersAll') {
                updateOrderTable(data)
            }
            else{
                // Handle other types of data
                console.log(data);
            }
        })
        .catch(error => console.error('Error:', error));
}

function updateProductTable(products) {
    const contentDiv = document.getElementById('content');
    let tableHTML = '<h2>商品列表</h2>';

    if (products.length === 0) {
        tableHTML += '<p>没有商品</p>';
    } else {
        tableHTML += `
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>标题</th>
                        <th>作者</th>
                        <th>价格</th>
                        <th>图片</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>`;

        products.forEach(product => {
            tableHTML += `
                <tr>
                    <td>${product.id}</td>
                    <td>${product.title}</td>
                    <td>${product.author}</td>
                    <td>${product.price}</td>
                    <td>${product.picture}</td>
                    <td><a href="/products/${product.id}/delete"><button type="button" class="btn btn-outline-success">删除</button></a></td>
                </tr>`;
        });

        tableHTML += '</tbody></table>';
    }

    tableHTML += `
        <div style="text-align: right">
            <!-- 触发模态窗口的按钮 -->
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addProductModal">
                添加商品
            </button>
        </div>
    `

    tableHTML += `
        <!-- 模态窗口 -->
    `

    contentDiv.innerHTML = tableHTML;
}

function updateUserTable(users) {
    const contentDiv = document.getElementById('content');
    let tableHTML = '<h2>用户列表</h2>';

    if (users.length === 0) {
        tableHTML += '<p>没有用户</p>';
    } else {
        tableHTML += `
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>用户名</th>
                        <th>用户类型</th>
                        <th>密码</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>`;

        users.forEach(user => { // Corrected this line
            tableHTML += `
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.role}</td>
                    <td>${user.password}</td>
                    <td><a href="/users/${user.id}/delete"><button type="button" class="btn btn-outline-success">删除</button></a></td>
                </tr>`;
        });

        tableHTML += '</tbody></table>';
    }

    contentDiv.innerHTML = tableHTML;
}

function updateOrderTable(orders) {
    const contentDiv = document.getElementById('content');
    let tableHTML = '<h2>订单列表</h2>';

    if (orders.length === 0) {
        tableHTML += '<p>没有订单</p>';
    } else {
        tableHTML += `
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>订单号</th>
                        <th>用户名</th>
                        <th>商品名</th>
                        <th>数量</th>
                        <th>总价格</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>`;

        orders.forEach(order => { // Corrected this line
            tableHTML += `
                <tr>
                    <td>${order.id}</td>
                    <td>${order.userName}</td>
                    <td>${order.bookTitle}</td>
                    <td>${order.quantity}</td>
                    <td>${order.totalPrice}</td>
                    <td><a href="/orders/${order.id}/delete"><button type="button" class="btn btn-outline-success">删除</button></a></td>
                </tr>`;
        });

        tableHTML += '</tbody></table>';
    }

    contentDiv.innerHTML = tableHTML;
}
