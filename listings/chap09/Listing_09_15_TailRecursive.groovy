import groovy.transform.TailRecursive

class ListUtil {
    static reverse(List list) {
        doReverse(list, [])
    }

    @TailRecursive
    private static doReverse(List todo, List done) {
        if (todo.isEmpty()) done
        else doReverse(todo.tail(), [todo.head()] + done)
    }
}

assert ListUtil.reverse(['a', 'b', 'c']) == ['c', 'b', 'a']
