package screen

object ScreenStack {
    private val screenStack = mutableListOf<Screen>()

    fun push(screen: Screen) { // parameter로 screen을 받아 stack에 추가
        screenStack.add(screen)
    }

    fun pop() { // 스택의 가장 상단 데이터 삭제
        screenStack.removeLastOrNull()
    }

    fun peek(): Screen? { // 스택의 가장 상단 데이터 조회
        return screenStack.lastOrNull() // lastOrNull 함수는 mutablelist에 데이터가 존재하지 않을 때는 index정보를 조회하지 않고 null을 반환해 runtime 오류를 발생하지 않음
    }

    // 원래는 isEmpty함수도 구현해 주어야 하지만 현재 list함수의 확장함수 사용으로 list에 데이터가 없을 시 null을 반환하도록 관련 확장함수를 사용했기 떄문에 생략해도 됨

}

sealed class Screen // 지금까지 추가했던 화면들이 sealed class Screen의 서브 클래스가 됨