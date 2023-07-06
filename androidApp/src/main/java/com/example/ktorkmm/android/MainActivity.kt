package com.example.ktorkmm.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.ktorkmm.JsonGetter

import androidx.compose.runtime.*;
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ktorkmm.CyberWork
import kotlinx.coroutines.launch;

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val scope = rememberCoroutineScope();

                    var works by remember {
                        mutableStateOf(listOf<CyberWork>());
                    };

                    var item = listOf(CyberWork("error","error","error"));

                    LaunchedEffect(true) {
                        scope.launch {
                            works = try {
                                JsonGetter().get_json().cyberpunk_works;
                            }
                            catch(e: Exception) {
                                val err = e.localizedMessage ?: "error";
                                listOf(CyberWork(err, err, err));
                            }
                        }
                    }
                    GreetingView(works);
                }
            }
        }
    }
}

@Composable
fun GreetingView(works: List<CyberWork>) {
    LazyColumn {
        items(works) {
            Text(
                text = "${it.name} (${it.year}), ${it.creator}",
                fontSize = 36.sp,
                modifier = Modifier.padding(8.dp)
            );
            Divider(color = Color.Gray, thickness = 1.dp);
        }
    }
}
