import android.content.Context
import android.content.Intent
import androidx.core.content.FileProvider
import java.io.File

fun exportarParaCsv(context: Context, enderecos: List<EnderecoEntity>): File {
    val file = File(context.filesDir, "enderecos.csv")
    file.bufferedWriter().use { writer ->
        writer.append("CEP,Logradouro,Bairro,Cidade,UF\n")
        enderecos.forEach { endereco ->
            writer.append("${endereco.cep},${endereco.logradouro},${endereco.bairro},${endereco.localidade},${endereco.uf}\n")
        }
    }
    return file
}

fun compartilharArquivo(context: Context, file: File) {
    val uri = FileProvider.getUriForFile(context, "${context.packageName}.provider", file)
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/csv"
        putExtra(Intent.EXTRA_STREAM, uri)
    }
    context.startActivity(Intent.createChooser(intent, "Compartilhar arquivo"))
}
