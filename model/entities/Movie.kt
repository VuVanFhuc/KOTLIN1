package ph34858.laptrinhkotlin.lab7Ph34858.model.entities

data class Movie(
    val title: String,
    val year: String,
    val posterUrl: String,
    val duration: Double,
    val releaseDate: String
) {
    companion object {
        fun getSampleMovies() = listOf(
            Movie("Kang Fu Panda 4", "2010", "https://lh4.googleusercontent.com/proxy/0ANH87_RsjcPVN_BPzv_LHYVYwO44rC9-yozjnYZUF2iqF36uvUJgSStqQuTfmcYHgtToTu7vXdqirFhitZH_XP36KbyZ-_qgxI87CX_Md0sg0Lt",3.0,"12/01/2024"),
            Movie("Hành Tinh Cát - Phần 2", "2010", "https://upload.wikimedia.org/wikipedia/vi/9/94/Dune_2_VN_poster.jpg",3.0,"Phim hay"),
            Movie("Mai", "2010", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTBwxAkLxonf5ByHa2ZNf3Aij7WTAxIlLeCq1rCyX5qHg&s",3.0,"20/5/2024"),
            Movie("Đào, Phở, Piano", "2010", "https://www.elle.vn/wp-content/uploads/2024/02/28/573479/poster-phim-dao-pho-va-piano.jpg",3.0,"20/5/2024"),
            Movie("Lật Mặt 7", "2010", "https://www.lofficielvietnam.com/_next/image?url=https%3A%2F%2Fwww.datocms-assets.com%2F56778%2F1712133247-posster-v2.jpg%3Fauto%3Dformat%252Ccompress%26cs%3Dsrgb&w=3840&q=75",3.0,"20/5/2024"),
            Movie("Harry Potter", "2010", "https://rukminim2.flixcart.com/image/850/1000/xif0q/poster/z/y/d/small-spos6935-poster-harry-potter-the-deathly-hallows-sl-6935-original-imaghmm5cbcnuhgf.jpeg?q=90&crop=false",3.0,"20/5/2024"),
            Movie("Inception", "2010", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2oWo4A-LMn4qjTL2gCBMUDGGYqkNz4B-iPg&s",3.0,"20/5/2024"),
            Movie("Inception", "2010", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2oWo4A-LMn4qjTL2gCBMUDGGYqkNz4B-iPg&s",3.0,"20/5/2024"),
            Movie("Inception", "2010", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2oWo4A-LMn4qjTL2gCBMUDGGYqkNz4B-iPg&s",3.0,"20/5/2024"),


            )
    }
}