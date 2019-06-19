function createItemList(allItems, inputs) {
  var list = [];

  for (var i = 0; i < inputs.length; i++) {
    var location = inputs[i].length;

    if(inputs[i].length > 10){
      location = inputs[i].indexOf("-");
    }

    var barcode = inputs[i].substring(0, location)

    for (var k = 0; k < allItems.length; k++) {
      if (barcode === allItems[k].barcode) {
        var newItem = {
          name: allItems[k].name,
          unit: allItems[k].unit,
          price: allItems[k].price,
          barcode: allItems[k].barcode,
          img: allItems[k].img
        }

        list.push(newItem)
      }
    }
  }

  return list;
}

function createCartList(itemList, inputs) {
  var cartList = [];

  // TODO...

  return cartList;
}

function caculateDiscount (cartList, promotions) {
  var cartItems = [];
  var discountProductList = [];

  // TODO...

  return { cartItems: cartItems, discountProductList: discountProductList };
}

function createSummary (cartItems, discountProductList) {
  var totalPrice = 0;
  var discountPrice = 0;

  for (var i = 0; i < cartItems.length; i++) {
    totalPrice += cartItems[i].totalPrice;
  }

  for (var k = 0; k < discountProductList.length; k++) {
    discountPrice += (discountProductList[k].count * discountProductList[k].price);
  }

  return {
    totalPrice: totalPrice,
    discountPrice: discountPrice
  };
}

function generateOutputs(inputs) {
  // 获取全部的商品
  var allItems = loadAllItems();
  // 获取全部的促销信息
  var promotions = loadPromotions();

  var itemList = createItemList(allItems, inputs)

  var cartList = createCartList(itemList, inputs)

  var discountInfo = caculateDiscount(cartList, promotions)

  var summary = createSummary(discountInfo.cartItems, discountInfo.discountProductList);

  var result = {
    cartItems: discountInfo.cartItems,
    discountProductList: discountInfo.discountProductList,
    summary: summary
  }

  return result
}
