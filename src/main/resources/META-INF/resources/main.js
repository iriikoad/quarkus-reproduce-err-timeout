
console.log("init");
clickLogin = (e) => {
    console.log("clickLogin", e);
    postLogin('admin', 'admin');
};


clickLoginErr = (e) => {
    console.log("clickLoginErr", e);
    postLogin('a', 'a');
};

postLogin = (user, pw) => {
    
    let formData = new FormData();
    formData.append('j_username', user);
    formData.append('j_password', pw);
    const data = new URLSearchParams();
    for (const pair of  formData) {
        data.append(pair[0], pair[1]);
    }
    fetch("/j_security_check",
            {
                body: data,
                method: "post"
            })
    .then(response => console.log(response));
};