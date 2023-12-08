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
