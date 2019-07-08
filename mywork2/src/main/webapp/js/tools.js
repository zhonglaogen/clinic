
//计时器 每隔30毫秒执行一次移动函数
function move(obj, attr, target, speed, callback) {
    clearInterval(obj.timer);
    var current = parseInt(getStyle(obj, attr));
    if (current > target) {
        speed = -speed;
    }
    obj.timer = setInterval(function () {
        var oldValue = parseInt(getStyle(obj, attr));
        var newValue = oldValue + speed;
        if ((0 < speed && newValue > target) || (speed < 0 && newValue < target)) {
            newValue = target;
        }
        obj.style[attr] = newValue + "px";
        if (target == newValue) {
            clearTimeout(obj.timer);
            callback && callback();
        }
    }, 30);
}

//获取obj距定位的距离
function getStyle(obj, name) {
    if (window.getComputedStyle) {
        /*
            没有window时是一个变量，需要在作用域中寻找，加了一window变成一个对象的属性
            变量和属性的区别，变量没找到报错，属性没找到返回undefined
        */
        //正常浏览器
        //因为name是变量，所以通过[]的方式来更加灵活获取变量的值
        return getComputedStyle(obj, null)[name];
    } else {
        //IE8的方式
        return obj.currentStyle[name];
    }
}

//添加CSS样式
function addClass(obj, cn) {
    if (!hasClass(obj, cn)) {
        obj.className += " " + cn;
    }
    // obj.className += " "+cn;
}

//判断obj中是否有cn class
function hasClass(obj, cn) {
    // var reg = /b\b2\b/;
    //创建正则表达式
    var reg = new RegExp("\\b" + cn + "\\b");
    // alert(reg);
    return reg.test(obj.className);
}

//删除CSS样式
function removeClass(obj, cn) {
    var reg = new RegExp("\\b" + cn + "\\b");
    //删除class
    obj.className = obj.className.replace(reg, "");
}

//toggleClass可以用来切换类 如果有删除 没有就添加
function toggleClass(obj, cn) {
    if (hasClass(obj, cn)) {
        removeClass(obj, cn);
    } else {
        addClass(obj, cn);
    }
}