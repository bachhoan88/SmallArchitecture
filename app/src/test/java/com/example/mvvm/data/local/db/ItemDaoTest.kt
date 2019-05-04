package com.example.mvvm.data.local.db

import com.example.mvvm.createItem
import com.example.mvvm.data.model.Item
import io.reactivex.observers.TestObserver
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Matchers.anyInt
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.util.concurrent.TimeUnit

@RunWith(RobolectricTestRunner::class)
@Config(sdk = intArrayOf(21))
class UserDaoTest : DbTest() {

    @Test
    fun testInsertAndGet() {
        val item = createItem()
        db.itemDao().insert(item)

        // create observer to get user entity with user id
        val testObserver = TestObserver<Item>()
        testObserver.awaitTerminalEvent(2, TimeUnit.SECONDS)

        // get user id
        db.itemDao().findById(item.id).toObservable().subscribe(testObserver)

        // data not null or no errors
        testObserver.assertNoErrors()
        testObserver.assertValue {
            item == it
        }
    }

    @Test
    fun findNotExists() {
        val itemId = anyInt()
        val testObserver = TestObserver<Item>()
        testObserver.awaitTerminalEvent(2, TimeUnit.SECONDS)

        db.itemDao().findById(itemId).toObservable().subscribe(testObserver)
        testObserver.assertValueCount(0)
    }

    @Test
    fun testInsertValueExists() {
        // create fake user
        val userId = 1
        val userEntity1 = Item(userId,
                "Bach",
                "Bach Van B",
                "https://api.github.com/users/yigit/repos")

        val userEntity2 = Item(userId,
                "Hoan",
                "Nguyen Van A",
                "https://api.github.com/users/yigit/repos")
        // first insert
        db.itemDao().insert(userEntity1)

        // re-insert user
        db.itemDao().insert(userEntity2)

        // check data
        val testObserver = TestObserver<Item>()
        testObserver.awaitTerminalEvent(2, TimeUnit.SECONDS)

        db.itemDao().findById(userId).toObservable().subscribe(testObserver)

        testObserver.assertNoErrors()
        testObserver.assertValue {
            it == userEntity2
        }
    }
}