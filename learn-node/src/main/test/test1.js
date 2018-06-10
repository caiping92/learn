var data = {
    name: 'jack',
    child: [
        {
            name: 'jack1',
            child: [
                {name: 'jack11'}
            ]
        }]
}
function getParenName(data, ret) {
    // let json = JSON.parse(data);
    let json = data;
    let children = json["child"];

    if (!children) {
        return;
    } else {
        ret.push(json["name"].toString());
        for (let i = 0; i < children.length; i++) {
            getParenName(children[i], ret);
        }
    }
}

//test start--
let ret = new Array();
getParenName(data, ret);
console.log(ret);
//test end--