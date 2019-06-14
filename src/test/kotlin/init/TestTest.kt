package init

import org.junit.jupiter.api.Test
import kotlin.test.fail


class TestTest(){

    fun getSomeValue(number: Int) : Int{
        return -1
    }



    @Test
    fun checkSomething(){
        fail()
    }
}
