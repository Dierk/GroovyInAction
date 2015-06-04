InetAddress.getAllByName("google.com").collect {
    it.toString().split('/')[1]
}
