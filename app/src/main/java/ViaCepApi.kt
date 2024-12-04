import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ViaCepApi {
    @GET("{cep}/json/")
    fun buscarCep(@Path("cep") cep: String): Call<Endereco>
}
