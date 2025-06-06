package com.example.mobileprogrammingui.ui

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.mobileprogrammingui.R

@Preview(showBackground = true)
@Composable
fun SimpleText() {
    Text("Hello World")
}

@Preview(showBackground = true)
@Composable
fun StringResourceText() {
    Text(stringResource(R.string.hello_world))
}

@Preview(showBackground = true)
@Composable
fun BlueText() {
    Text("Hello World", color = Color.Blue)
}

@Preview(showBackground = true)
@Composable
fun BigText() {
    Text("Hello World", fontSize = 30.sp)
}

@Preview(showBackground = true)
@Composable
fun ItalicText() {
    Text("Hello World", fontStyle = FontStyle.Italic)
}

@Preview(showBackground = true)
@Composable
fun BoldText() {
    Text("Hello World", fontWeight = FontWeight.Bold)
}

@Preview(showBackground = true)
@Composable
fun CenterText() {
    Text(
        "Hello World",
        modifier = Modifier.width(150.dp),
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true)
@Composable
fun TextShadow() {
    val offset = Offset(5.0f, 10.0f)
    Text(
        text = "Hello world!",
        style = TextStyle(
            fontSize = 24.sp,
            shadow = Shadow(
                color = Color.Blue,
                offset = offset,
                blurRadius = 3f
            )
        )
    )
}

@Preview(showBackground = true)
@Composable
fun DifferentFonts() {
    Column {
        Text("Hello World", fontFamily = FontFamily.Serif)
        Text("Hello World", fontFamily = FontFamily.SansSerif)
    }
}

@Preview(showBackground = true)
@Composable
fun MultipleStylesInText() {
    Text(
        buildAnnotatedString { // 문자열의 특정부분에 개별적 스타일 적용
            withStyle(style = SpanStyle(color = Color.Blue)) {
                append("H")
            }
            append("ello ")

            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Red)) {
                append("W")
            }
            append("orld")
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ParagraphStyle() {
    Text(
        buildAnnotatedString {
            withStyle(style = androidx.compose.ui.text.ParagraphStyle(lineHeight = 30.sp)) {
                withStyle(style = SpanStyle(color = Color.Blue)) {
                    append("Hello\n")
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.Red
                    )
                ) {
                    append("World\n")
                }
                append("Compose")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun LongText() {
    Text("hello ".repeat(50), maxLines = 2)
}

@Preview(showBackground = true)
@Composable
fun OverflowedText() {
    Text("Hello Compose ".repeat(50), maxLines = 2, overflow = TextOverflow.Ellipsis) // ... 으로 표시
}

@Preview(showBackground = true)
@Composable
fun AlignedText() {
    Text(
        text = "greenjoa",
        style = LocalTextStyle.current.merge( // 텍스트의 줄 간격과 정렬 방식을 세밀하게 제어
            TextStyle(
                lineHeight = 2.5.em, // 텍스트의 줄 간격을 글꼴의 2.5배 설정 ( em : 글꼴의 높이를 고려한 상대적인 크기 )
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false // 플랫폼별 기본 폰트 패딩 사용하지 않음
                ),
                lineHeightStyle = LineHeightStyle(
                    alignment = LineHeightStyle.Alignment.Center,
                    trim = LineHeightStyle.Trim.None  // 텍스트 주변 여백 유지
                )
            )
        )
    )
}

@Preview(showBackground = true)
@Composable
fun SelectableText() {
    SelectionContainer { // 내부에 포함된 텍스트를 드래그하여 선택
        Text("This text is selectable")
    }
}

@Preview(showBackground = true)
@Composable
fun PartiallySelectableText() {
    SelectionContainer {
        Column {
            Text("This text is selectable")
            Text("This one too")
            Text("This one as well")
            DisableSelection {
                Text("But not this one")
                Text("Neither this one")
            }
            Text("But again, you can select this one")
            Text("And this one too")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SimpleClickableText() {
    ClickableText(
        text = AnnotatedString("Click Me"),
        onClick = { offset ->
            Log.d("ClickableText", "$offset -th character is clicked.")
        }
    )
}

@Preview(showBackground = true)
@Composable
fun AnnotatedClickableText() {
    val annotatedText = buildAnnotatedString {
        append("Click ")

        // We attach this *URL* annotation to the following content
        // until `pop()` is called
        pushStringAnnotation(
            tag = "URL",
            annotation = "https://developer.android.com"
        )
        withStyle(
            style = SpanStyle(
                color = Color.Blue,
                fontWeight = FontWeight.Bold
            )
        ) {
            append("here")
        }
        pop()
    }

    ClickableText(
        text = annotatedText,
        onClick = { offset ->
            // We check if there is an *URL* annotation attached to the text
            // at the clicked position
            annotatedText.getStringAnnotations(
                tag = "URL",
                start = offset,
                end = offset
            )
                .firstOrNull()?.let { annotation ->
                    // If yes, we log its value
                    Log.d("Clicked URL", annotation.item)
                }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun TextDecorationStyle() {
    Column {
        Text(
            text = "Text with Underline",
            style = TextStyle(
                color = Color.Black,
                fontSize = 24.sp,
                textDecoration = TextDecoration.Underline
            )
        )
        Text(
            text = "Text with Strike",
            style = TextStyle(
                color = Color.Blue,
                fontSize = 24.sp,
                textDecoration = TextDecoration.LineThrough
            )
        )
    }
}