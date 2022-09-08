package data

object CartItems {  // CartItems는 프로젝트 전역에서 상품 데이터를 저장하는 클래스이므로 항상 같은 값이 유지되어야 하기 때문에 싱글턴 객체로 만드는 것이 적합
    private val mutableProducts = mutableMapOf<Product, Int>() // 상품 데이터를 저장할 수 있는 데이터 타입으로 Map 사용, 상품의 수량 정보도 함께 저장하기 위함
    val products:Map<Product, Int> = mutableProducts

    fun addProduct(product: Product) {
        mutableProducts[product]?.let {
            mutableProducts[product] = it +1
        } ?: kotlin.run {
            mutableProducts[product] = 1
        }
    }
}