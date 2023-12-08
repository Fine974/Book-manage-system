function fetchData(type) {
    fetch(`http://localhost:8080/${type}`)
        .then(response => response.json())
        .then(data => {
            if (type === 'productsAll') {
                updateProductTable(data); // Update the table with product data
            } else if (type === 'userAll') {
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
    const contentDiv = document.getElementById('content1');
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
                    <td><a href="/products/${product.id}/delete">删除</a></td>
                </tr>`;
        });

        tableHTML += '</tbody></table>';
    }

    contentDiv.innerHTML = tableHTML;
}

function updateUserTable(users) {
    const contentDiv = document.getElementById('content2');
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
                    <td><a href="/users/${user.id}/delete">删除</a></td>
                </tr>`;
        });

        tableHTML += '</tbody></table>';
    }

    contentDiv.innerHTML = tableHTML;
}