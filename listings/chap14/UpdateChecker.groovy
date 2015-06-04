class UpdateChecker {
  static check(text) {
    def updated = new XmlParser().parseText(text)
    updated.week[0].with { w0 ->
      assert w0.task.@done*.toInteger().sum() == 7
      assert w0.find{ it.text() == 'time saver' }
    }
    updated.week[1].with { w1 ->
      assert w1.children().size() == 3
      assert w1.find{ it.@total == "4" }
      assert w1.find{ it.@title == "build web service client" }
      assert !w1.find{ it.@title == "use DB/XML combination" }
    }
  }
}