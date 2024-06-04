import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp

@Composable
fun ScheduleDateTextField(
    value: String,
    placeholder: String,
    icon: ImageVector,
    onIconClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var currentPlaceholder by remember { mutableStateOf(placeholder) }

    LaunchedEffect(value) {
        if (value.isNotEmpty()) {

            currentPlaceholder = value
        } else {
            currentPlaceholder = placeholder
        }
    }

    OutlinedTextField(
        value = value,
        onValueChange = { },
        placeholder = {
            Text(text = currentPlaceholder)
        },
        readOnly = true,
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.Sentences,
            imeAction = ImeAction.Done
        ),
        shape = RoundedCornerShape(8.dp),
        trailingIcon = {
            IconButton(onClick = onIconClick) {
                Icon(
                    imageVector = icon,
                    contentDescription = "Icon Tanggal",
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
        },
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    )
}
