function () {
    this.pets.forEach(
        function(z) {
            emit(z.type, { count:1 });
        }
    )
}