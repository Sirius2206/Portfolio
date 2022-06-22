const decrementBtns = document.querySelectorAll('.product__quantity-control_dec');
const incrementBtns = document.querySelectorAll('.product__quantity-control_inc');
const addToCartButtons = Array.from(document.querySelectorAll('.product__add'));
const deleteFromCartBtns = Array.from(document.querySelectorAll('.product__delete'));
const cartProducts = document.querySelector('.cart__products');
const cart = document.querySelector('.cart');

const savedData = window.localStorage;
restoreSavedData();

initializeButtons();

//создать товар в корзине, если его там нет
function addToCart(product) {
    const resultDiv = document.createElement('div');
    resultDiv.classList.add('cart__product');
    resultDiv.dataset.id = product.dataset.id;

    const image = product.querySelector('img').cloneNode(false);
    resultDiv.appendChild(image);

    let count = document.createElement('div');
    count.classList.add('cart__product-count');
    count.innerText = product.querySelector('.product__quantity-value').innerText;
    resultDiv.appendChild(count);

    cartProducts.appendChild(resultDiv);
    product.querySelector('.product__delete').classList.add('product__delete_active');
}

//анимация перелета товара в корзину
function animate(product, cartProduct) {
    const body = document.querySelector('body');
    const prodCoord = product.querySelector('img').getBoundingClientRect();
    let {
        x: prodX,
        y: prodY
    } = prodCoord;
    const cartCoord = cartProduct.querySelector('img').getBoundingClientRect();
    let {
        x: cartX,
        y: cartY
    } = cartCoord;

    const image = product.querySelector('img').cloneNode(false);
    image.style.marginLeft = prodX + 'px';
    image.style.marginTop = prodY + 'px';
    image.style.position = 'absolute';
    body.insertBefore(image, document.querySelector('header'));

    let deltaX = cartX - prodX;
    let deltaY = cartY - prodY;

    let modX = deltaX / (1000/60);
    let modY = deltaY / (1000/60);

    let posX = prodX;
    let posY = prodY;
    const timer = setInterval(() => {
        posX += modX
        image.style.marginLeft = posX + modX + 'px';
        posY += modY;
        image.style.marginTop = posY + modY + 'px';
        if (posX > deltaX) {
            clearInterval(timer);
            image.remove();
        }
    }, 1000/60)
}

function cartHasProduct(product) {
    let cartProduct = cartProducts.querySelector(`[data-id = '${product.dataset.id}']`);
    if (cartProduct) return cartProduct;
    return false;
}

//функция изменения количества при нажатии на + или -
function changeQuantity(mod, value) {
    let val = Number.parseInt(value.innerText);
    val += mod;
    if (val < 1) {
        return;
    }
    value.innerText = val;
}

//привязывание событий всем кнопкам
function initializeButtons() {
    for (let button of deleteFromCartBtns) {
        button.addEventListener('click', e => {
            const productId = button.closest('div.product').dataset.id;
            const cartProduct = cartProducts.querySelector(`[data-id = "${productId}"]`);
            cartProduct.remove();
            button.classList.remove('product__delete_active')
            if (cartProducts.querySelector('.cart__product') === null) {
                cart.style.display = 'none';
            }
            save(cartProducts.innerHTML);
        })
    }
    for (let button of decrementBtns) {
        const quantityDiv = button.closest('div.product__quantity-controls').querySelector('.product__quantity-value');
        button.addEventListener('click', () => {
            changeQuantity(-1, quantityDiv)
        });
    }

    for (let button of incrementBtns) {
        const quantityDiv = button.closest('div.product__quantity-controls').querySelector('.product__quantity-value');
        button.addEventListener('click', () => {
            changeQuantity(1, quantityDiv)
        });
    }

    for (let button of addToCartButtons) {
        button.addEventListener('click', e => {
            cart.style.display = 'block';
            const product = button.closest('div.product');
            const cartProduct = cartHasProduct(product);
            if (!cartProduct) {
                addToCart(product);
                save(cartProducts.innerHTML);
                return;
            }
            animate(product, cartProduct);
            let cartCount = Number.parseInt(cartProduct.querySelector('.cart__product-count').innerText);
            const productCount = Number.parseInt(product.querySelector('.product__quantity-value').innerText);

            cartCount += productCount;
            cartProduct.querySelector('.cart__product-count').innerText = cartCount;

            save(cartProducts.innerHTML);
        })
    }
}

//восстановить сохраненные данные
function restoreSavedData() {
    if (savedData.getItem('history')) {
        cartProducts.innerHTML = savedData.getItem('history');
        const prods = cart.querySelectorAll('.cart__product');
        for (let prod of prods) {
            document.querySelector('.products')
                .querySelector(`[data-id="${prod.dataset.id}"]`)
                .querySelector('.product__delete')
                .classList.add('product__delete_active')
        }
        cart.style.display = 'block';
    }
}

//сохранить
function save(toSave) {
    savedData.removeItem('history');
    savedData.setItem('history', toSave);
}