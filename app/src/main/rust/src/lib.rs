pub fn helloFromRust() -> String {
    String::from("Hello from Rust v1")
}

uniffi_macros::include_scaffolding!("rust");